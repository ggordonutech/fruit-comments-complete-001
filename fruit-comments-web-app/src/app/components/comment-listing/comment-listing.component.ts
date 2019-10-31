import { Component, OnInit } from '@angular/core';
import { CommentService } from 'src/app/services/comment.service';
import {Comment} from './../../entities/comment';

@Component({
  selector: 'app-comment-listing',
  templateUrl: './comment-listing.component.html',
  styleUrls: ['./comment-listing.component.scss']
})
export class CommentListingComponent implements OnInit {

  comments:Comment[] = [];
  

  constructor(
    private commentService : CommentService
  ) {
    
   }

  ngOnInit() { 
    this.commentService.add(new Comment({
       author :'John Luke',
       comment :'Pineapples are great!',
       fruitId : 4,
       rating: 5
    }))
    this.commentService.add(new Comment({
      author :'Marsha Brown',
      comment :'I like oranges in the morning!',
      fruitId : 3,
      rating: 3
   }))
    this.commentService.getAll().subscribe(results => {
      this.comments = results;
    })
  }

}
