import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CoursesService } from './../../services/courses.service';
import { ActivatedRoute } from '@angular/router';
import { Course } from '../../model/course';

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.scss'],
})
export class CourseFormComponent implements OnInit {
  /// https://angular.io/guide/typed-forms
  form = this.formBuilder.group({
    _id: [''],
    name: [
      '',
      [Validators.required, Validators.minLength(5), Validators.maxLength(100)],
    ],
    category: ['', [Validators.required]],
  });

  constructor(
    private service: CoursesService,
    private formBuilder: NonNullableFormBuilder,
    private snackBar: MatSnackBar,
    private location: Location,
    private route: ActivatedRoute
  ) {
    // this.form
  }

  onSubmit() {
    this.service.save(this.form.value).subscribe({
      next: (data) => {
        this.onSuccess();
        this.location.back();
      },
      error: (error) => {
        this.onError(error);
      },
    });
  }

  onCancel() {
    this.location.back();
  }

  ngOnInit(): void {
    const course: Course = this.route.snapshot.data['course'];

    // patch: somente alguns valores
    this.form.setValue(course);
  }

  private onSuccess() {
    this.snackBar.open(`Course save with success.`, '', { duration: 5000 });
  }

  private onError(error: any) {
    this.snackBar.open(
      `An unexpected error occurs. Try again later.: ${JSON.stringify(
        error.message
      )}`,
      '',
      { duration: 5000 }
    );
  }
}
