import { Injectable } from '@nestjs/common';
import { PrismaService } from 'src/prisma/prisma.service';
import { CustomerRepository } from './customer.repository';

@Injectable()
export class CustomerService {
  constructor(
    private prisma: PrismaService,
    private customerRepository: CustomerRepository,
  ) {}

  async findAll() {
    return this.prisma.customer.findMany();
  }

  async findOne(customer_id: number) {
    return this.prisma.customer.findUnique({ where: { customer_id } });
  }

  async create(data) {
    return this.prisma.customer.create({ data });
  }

  async update(customer_id: number, data) {
    return this.prisma.customer.update({
      where: { customer_id },
      data,
    });
  }

  async remove(customer_id: number) {
    return this.prisma.customer.delete({ where: { customer_id } });
  }

  async getCustomerFullNamesAndEmail() {
    return this.prisma.findCustomerFullNames(
      'linda.williams@sakilacustomer.org',
    );
  }
}
