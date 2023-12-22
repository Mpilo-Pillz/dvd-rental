import { PrismaService } from 'src/prisma/prisma.service';

export class CustomerRepository {
  constructor(private prisma: PrismaService) {}

  async findCustomerFullNames(email: string) {
    return this.prisma
      .$queryRaw`SELECT first_name,last_name,email FROM customer WHERE email = ${email}`;
  }

  async updateCustomerStatus(customerId: number, status: boolean) {
    return this.prisma
      .$executeRaw`UPDATE customer SET active = ${status} WHERE customer_id = ${customerId}`;
  }
}
