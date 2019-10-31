import { Injectable } from '@angular/core';
import { Comment } from './../entities/comment';
import { BehaviorSubject, Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private comments: Comment[] = [];
  private lastAuthorName: BehaviorSubject<string>;

  constructor() { 
    this.lastAuthorName = new BehaviorSubject<string>(null);
  }

  public add(comment: Comment) : Observable<boolean> {
    comment.id = this.comments.length + 1;
    this.comments.push(comment);
    this.lastAuthorName.next(comment.author);
    return of(true);
  }

  public getAll():Observable<Comment[]> {
    return of(this.comments);
  }

  public getLastAuthorName():Observable<string>{
    return this.lastAuthorName;
  }
}
