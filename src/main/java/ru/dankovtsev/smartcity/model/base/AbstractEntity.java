package ru.dankovtsev.smartcity.model.base;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.UUID;

@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@MappedSuperclass
public class AbstractEntity {
    @JsonProperty
    @Id
    @Column(name = "id", columnDefinition = "id")
    private UUID id;

    @JsonIgnore
    @Column(name = "created_timestamp", insertable = true, updatable = false)
    private Timestamp createdTimestamp;

    @JsonIgnore
    @Column(name = "updated_timestamp")
    private Timestamp updatedTimestamp;

    @JsonIgnore
    @Column(name = "deleted")
    private Boolean deleted = false;

    @PrePersist
    protected void prePersist() {
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }
        createdTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
    }
    @PreUpdate
    protected void preUpdate() {
        updatedTimestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Timestamp getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public Timestamp getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Timestamp updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || !(o == null || getClass() != o.getClass()) && id.equals(((AbstractEntity) o).id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{id=" + id + "}";
    }
}
