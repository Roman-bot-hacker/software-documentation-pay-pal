import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'payment-system',
        loadChildren: () => import('./payment-system/payment-system.module').then(m => m.PayPalPaymentSystemModule)
      },
      {
        path: 'country',
        loadChildren: () => import('./country/country.module').then(m => m.PayPalCountryModule)
      },
      {
        path: 'bank',
        loadChildren: () => import('./bank/bank.module').then(m => m.PayPalBankModule)
      },
      {
        path: 'credit-card',
        loadChildren: () => import('./credit-card/credit-card.module').then(m => m.PayPalCreditCardModule)
      },
      {
        path: 'currency',
        loadChildren: () => import('./currency/currency.module').then(m => m.PayPalCurrencyModule)
      },
      {
        path: 'payment-account',
        loadChildren: () => import('./payment-account/payment-account.module').then(m => m.PayPalPaymentAccountModule)
      },
      {
        path: 'user-account',
        loadChildren: () => import('./user-account/user-account.module').then(m => m.PayPalUserAccountModule)
      },
      {
        path: 'payment-transaction',
        loadChildren: () => import('./payment-transaction/payment-transaction.module').then(m => m.PayPalPaymentTransactionModule)
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ]
})
export class PayPalEntityModule {}
