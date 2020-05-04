import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LibraryComponent } from './library/library.component';
import { BookComponent } from './book/book.component';


const routes: Routes = [
  { path: 'home', component: LibraryComponent },
  { path: 'library', component: LibraryComponent },
  { path: 'book/:libraryId', component: BookComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
