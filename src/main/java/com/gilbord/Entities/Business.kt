package com.gilbord.Entities

import javax.persistence.*
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(name = "BUSINESS")
public data class Business(@Id
                           @GeneratedValue(generator = "increment")
                           @GenericGenerator(name = "increment", strategy = "increment")
                           val id: Long,
                           @Column(name = "business_address", nullable = false) val address: String,
                           @Column(name = "business_name", nullable = false) val name: String)