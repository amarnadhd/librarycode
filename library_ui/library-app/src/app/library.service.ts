import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http'
import { ILibrary } from './library/ILibrary';
import { Observable } from 'rxjs';
import { IBook } from './book/book';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'  
  })
};

@Injectable()
export class LibraryService {

  constructor(private httpClient: HttpClient) {}
  getLibraries(): Observable<ILibrary[]> {

    return this.httpClient.get<ILibrary[]>("http://localhost:8087/library/");
  }

  getBooksByLibrary(libraryId: number): Observable<IBook[]> {
    let booksUrl: string = "http://localhost:8087/library/" + libraryId + "/book";
    return this.httpClient.get<IBook[]>(booksUrl);
  }
}
