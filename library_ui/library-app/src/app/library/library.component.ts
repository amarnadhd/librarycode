import { Component, OnInit } from '@angular/core';
import { ILibrary } from './ILibrary';
import { LibraryService } from '../library.service';

@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.css']
})
export class LibraryComponent implements OnInit {

  libraries: ILibrary[];
  constructor(private libraryService: LibraryService) { }

  ngOnInit() {
    this.libraryService.getLibraries().subscribe(libraryData => { 
      this.libraries = libraryData
    });
  }

}
