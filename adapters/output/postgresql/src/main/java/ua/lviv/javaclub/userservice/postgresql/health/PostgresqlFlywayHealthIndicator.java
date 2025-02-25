package ua.lviv.javaclub.userservice.postgresql.health;
import lombok.RequiredArgsConstructor;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;
import org.flywaydb.core.api.MigrationInfoService;
import org.flywaydb.core.api.MigrationState;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class PostgresqlFlywayHealthIndicator implements HealthIndicator {

  private final Flyway flyway;

  @Override
  public Health health() {
    MigrationInfoService infoService = flyway.info();
    MigrationInfo[] migrations = infoService.all();

    boolean hasFailedMigration = false;
    Map<String, String> migrationDetails = new HashMap<>();
    String latestMigration = "None";

    for (MigrationInfo migration : migrations) {
      MigrationState state = migration.getState();
      migrationDetails.put(migration.getVersion().toString(),
          migration.getScript() + " - " + state.getDisplayName());

      if (state == MigrationState.FAILED) {
        hasFailedMigration = true;
      }

      // Keep track of the latest applied migration
      if (migration.getState() == MigrationState.SUCCESS) {
        latestMigration = migration.getScript();
      }
    }

    if (hasFailedMigration) {
      return Health.down()
          .withDetail("Flyway Status", "Migration failure detected")
          .withDetail("Migrations", migrationDetails)
          .withDetail("Latest Migration Script", latestMigration)
          .build();
    }

    return Health.up()
        .withDetail("Flyway Status", "All migrations applied successfully")
        .withDetail("Migrations", migrationDetails)
        .withDetail("Latest Migration Script", latestMigration)
        .build();
  }
}
