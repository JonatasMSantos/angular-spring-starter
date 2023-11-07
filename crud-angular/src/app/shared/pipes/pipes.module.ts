import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CategoryPipe } from './category.pipe';



@NgModule({
  declarations: [CategoryPipe],
  imports: [
    CommonModule
  ],
  exports: [
    CategoryPipe
  ]
})
export class PipesModule { }
