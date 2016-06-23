package spittr;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.LocalDateTime;

public class Spittle {

    private final Long id;
    private final String message;
    private final LocalDateTime localDateTime;
    private Double latitude; //широта
    private Double longitude; //долгота

    public Spittle(String message, LocalDateTime time) {
        this(null, message, time, null, null);
    }

    public Spittle(Long id, String message, LocalDateTime time, Double longitude, Double latitude) {
        this.id = id;
        this.message = message;
        this.localDateTime = time;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "id", "localDateTime");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "localDateTime");
    }

}
