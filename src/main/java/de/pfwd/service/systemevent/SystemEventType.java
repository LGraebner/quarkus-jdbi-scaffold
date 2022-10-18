package de.pfwd.service.systemevent;


import de.pfwd.service.notification.NotificationSeverity;

public enum SystemEventType {

  SYSTEM_INITIALIZED,
  SYSTEM_DEACTIVATED,
  SYSTEM_PAUSED,
  HEARTBEAT,

  TEMPERATURE_TOO_HOT,
  TEMPERATURE_TOO_COLD,
  DISK_SPACE_ALMOST_FULL,

  FAN_MALFUNCTION,
  NO_MORE_DISKSPACE,
  SYSTEM_CRASH;

}