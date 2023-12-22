import { Module } from '@nestjs/common';
import { CustomerService } from './customer.service';
import { CustomerController } from './customer.controller';
import { PrismaModule } from 'src/prisma/prisma.module';
import { CustomerRepository } from './customer.repository';

@Module({
  imports: [PrismaModule],
  providers: [CustomerService, CustomerRepository],
  controllers: [CustomerController],
})
export class CustomerModule {}
