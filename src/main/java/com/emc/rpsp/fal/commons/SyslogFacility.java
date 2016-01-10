package com.emc.rpsp.fal.commons;

import lombok.AllArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@AllArgsConstructor
public enum SyslogFacility {
    AUTH("Auth"),
    AUTHPRIV("Authpriv"),
    CRON("Cron"),
    DAEMON("Daemon"),
    FTP("Ftp"),
    KERN("Kern"),
    LOCAL0("Local0"),
    LOCAL1("Local1"),
    LOCAL2("Local2"),
    LOCAL3("Local3"),
    LOCAL4("Local4"),
    LOCAL5("Local5"),
    LOCAL6("Local6"),
    LOCAL7("Local7"),
    LPR("Lpr"),
    MAIL("Mail"),
    NEWS("News"),
    SYSLOG("Syslog"),
    USER("User"),
    UUCP("UUCP"),
    UNKNOWN("Unknown");

    private String name;

    public String toString() {
        return name;
    }

}
