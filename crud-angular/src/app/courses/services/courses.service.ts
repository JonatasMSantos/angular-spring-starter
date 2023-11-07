import { Injectable } from '@angular/core';
import { Course } from '../model/course';

import { HttpClient } from '@angular/common/http';
import { Observable, delay, first, tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CoursesService {

  private readonly API = '/assets/courses.json'

  constructor(private httpClient: HttpClient) {}

    findAll(): Observable<Course[]> {
    return this.httpClient.get<Course[]>(this.API).pipe(
      first(),
      // delay(5000),
      tap(courses => console.log(courses))
    );
  }
}
