import { Component, OnInit } from '@angular/core';
import { FruitService } from 'src/app/services/fruit.service';
import { Fruit } from 'src/app/entities/fruit';
import { Comment } from 'src/app/entities/comment'
import { CommentService } from 'src/app/services/comment.service';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs';

@Component({
  selector: 'app-new-fruit-comment',
  templateUrl: './new-fruit-comment.component.html',
  styleUrls: ['./new-fruit-comment.component.scss']
})
export class NewFruitCommentComponent implements OnInit {

  fruits : Fruit[] = [];

  newComment : Comment;

  constructor(
    private fruitService: FruitService,
    private commentService: CommentService
  ) { 
    this.newComment = new Comment();
  }

  ngOnInit() {
    this.fruitService.getAll().subscribe(fruitItems => {
      this.fruits = fruitItems;
    })
  }

  addComment(){
    let fruit = this.fruits.find((fruit)=>{
      return fruit.id == this.newComment.fruitId;
    })
    // let fruit: Fruit;
    // for(var i=0;i<this.fruits.length;i++){
    //     if(this.fruits[i].id == this.newComment.fruitId){
    //       fruit = this.fruits[i];
    //     }
    // }
    this.newComment.fruit = fruit;
    console.log("Adding Comment: ",this.newComment)
    this.commentService.add(this.newComment)
       .pipe(
         catchError(err=>{
           console.error(err);
           window.alert("Unable to Post Comment, please try again")
           return of(false)
         })
       )
       .subscribe(success => {
         if(success){
           this.newComment = new Comment();
           window.alert("Posted Successfully")
         }else{
          window.alert("Unable to Post Comment, please try again")
         }
       })
  }

}
