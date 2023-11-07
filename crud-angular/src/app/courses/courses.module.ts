import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { ComponentsModule } from '../shared/components/components.module';
import { PipesModule } from '../shared/pipes/pipes.module';
import { UIModule } from '../shared/ui/ui.module';
import { CoursesRoutingModule } from './courses-routing.module';
import { CoursesComponent } from './courses/courses.component';

@NgModule({
  declarations: [
    CoursesComponent
  ],
  imports: [
    PipesModule,
    CommonModule,
    ComponentsModule,
    CoursesRoutingModule,
    UIModule,
  ]
})
export class CoursesModule { }
