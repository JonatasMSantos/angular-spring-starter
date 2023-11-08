import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { ComponentsModule } from '../shared/components/components.module';
import { PipesModule } from '../shared/pipes/pipes.module';
import { UIModule } from '../shared/ui/ui.module';
import { CoursesRoutingModule } from './courses-routing.module';
import { CoursesComponent } from './containers/courses/courses.component';
import { CourseFormComponent } from './containers/course-form/course-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import { CourseListComponent } from './components/course-list/course-list.component';

@NgModule({
  declarations: [
    CoursesComponent,
    CourseFormComponent,
    CourseListComponent
  ],
  imports: [
    PipesModule,
    CommonModule,
    ComponentsModule,
    CoursesRoutingModule,
    UIModule,
    ReactiveFormsModule
  ]
})
export class CoursesModule { }
