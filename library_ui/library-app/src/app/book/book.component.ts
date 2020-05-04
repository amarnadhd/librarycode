import { Component, OnInit } from '@angular/core';
import { LibraryService } from '../library.service';
import { IBook } from './book';
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  books: IBook[];
  libraryId: number = 1;
  
  constructor(private libraryService: LibraryService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.libraryId = Number(params.get("libraryId"))
    })
    this.libraryService.getBooksByLibrary(this.libraryId).subscribe(bookData => { 
      this.books = bookData
    });
  }

}
