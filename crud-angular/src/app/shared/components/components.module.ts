import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { MatDialogModule } from '@angular/material/dialog';
import { ErrorDialogComponent } from './error-dialog/error-dialog.component';
import { UIModule } from '../ui/ui.module';
import { ConfirmationDialogComponent } from './confirmation-dialog/confirmation-dialog.component';

@NgModule({
  declarations: [ErrorDialogComponent, ConfirmationDialogComponent],
  imports: [CommonModule, MatDialogModule, UIModule],
  exports: [ErrorDialogComponent],
})
export class ComponentsModule {}
