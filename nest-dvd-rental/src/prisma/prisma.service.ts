import { Injectable, OnModuleDestroy, OnModuleInit } from '@nestjs/common';
import { PrismaClient } from '@prisma/client';

@Injectable()
export class PrismaService
  extends PrismaClient
  implements OnModuleInit, OnModuleDestroy
{
  async onModuleInit() {
    await this.$connect();
  }

  async onModuleDestroy() {
    await this.$disconnect();
  }

  async findCustomerFullNames(email: string) {
    return this
      .$queryRaw`SELECT first_name,last_name,email FROM customer WHERE email = ${email}`;
  }

  async updateCustomerStatus(customerId: number, status: boolean) {
    return this
      .$executeRaw`UPDATE customer SET active = ${status} WHERE customer_id = ${customerId}`;
  }
}
