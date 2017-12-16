package com.gilbord.Web

import com.gilbord.Entities.Business
import com.gilbord.Repository.BusinessRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class BusinessController {

    @Autowired
    lateinit var businessRepository: BusinessRepository

    @RequestMapping(value = "/business",
            method = arrayOf(RequestMethod.POST),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    public fun saveBusiness(@RequestBody business: Business): ResponseEntity<Business> {
        return ResponseEntity(this.businessRepository.save(business), HttpStatus.OK)
    }

    @RequestMapping(value = "/business/{id}",
            method = arrayOf(RequestMethod.GET),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun getBusiness(@PathVariable(value = "id") businessId: Long): ResponseEntity<Business> {
        val business = this.businessRepository.findOne(businessId)
        return if (business != null) {
            ResponseEntity(business, HttpStatus.OK)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @RequestMapping(value = "/business",
            method = arrayOf(RequestMethod.GET),
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun getAllBusiness(): ResponseEntity<List<Business>> {
        val business = this.businessRepository.findAll()
        return if (business.isEmpty()) {
            ResponseEntity(business, HttpStatus.OK)
        } else {
            ResponseEntity.notFound().build()
        }
    }

}