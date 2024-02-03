package dev.camila.request.credit.system.service.impl

import dev.camila.request.credit.system.entity.Customer
import dev.camila.request.credit.system.exception.BusinessException
import dev.camila.request.credit.system.repository.CustomerRepository
import dev.camila.request.credit.system.service.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) : ICustomerService {
    override fun save(customer: Customer): Customer = this.customerRepository.save(customer)


    override fun findById(id: Long): Customer = this.customerRepository.findById(id)
        .orElseThrow { throw BusinessException("Id $id not found") }

    override fun delete(id: Long) {
        val customer: Customer = this.findById(id)
        this.customerRepository.delete(customer)
    }
}