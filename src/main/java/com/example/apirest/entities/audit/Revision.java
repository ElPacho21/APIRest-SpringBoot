package com.example.apirest.entities.audit;

import com.example.apirest.config.CustomRevisionListener;
import lombok.*;
import org.hibernate.envers.*;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "REVISION_INFO")
@RevisionEntity(CustomRevisionListener.class)
@Data

public class Revision implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="revision_seq")
    @SequenceGenerator(name = "revision_seq", sequenceName = "seq_revision_id")
    @RevisionNumber
    private int id;

    @Column(name = "REVISION_DATE")
    @Temporal(TemporalType.TIMESTAMP) //Por que es un dato de tipo Date
    @RevisionTimestamp
    private Date date;
}