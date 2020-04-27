import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { PayPalSharedModule } from 'app/shared/shared.module';
import { PayPalCoreModule } from 'app/core/core.module';
import { PayPalAppRoutingModule } from './app-routing.module';
import { PayPalHomeModule } from './home/home.module';
import { PayPalEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    PayPalSharedModule,
    PayPalCoreModule,
    PayPalHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    PayPalEntityModule,
    PayPalAppRoutingModule
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent]
})
export class PayPalAppModule {}
