package com.gilbord.Entities

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "DRUG")
data class Drug(@Id
                @GeneratedValue(generator = "increment")
                @GenericGenerator(name = "increment", strategy = "increment")
                var id: Long = 0,
                @Column(name = "contraindications") var contraindications: String = "",
                @Column(name = "active_substance", nullable = false) var activeSubstance: String,
                @Column(name = "side_effects") var sideEffects: String = "",
                @Column(name = "drug_name", nullable = false) var name: String,
                @ManyToOne(cascade = arrayOf(CascadeType.ALL))
                @JoinColumn(name = "business_id") var business: Business,
                @Column(name = "cost", nullable = false) var cost: Float)