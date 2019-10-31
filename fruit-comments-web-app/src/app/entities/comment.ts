import { Fruit } from './fruit';

export class Comment {
    id : number = 0;
    author : string;
    comment: string;
    rating : number;
    fruitId : number;
    fruit? : Fruit;

    constructor(props:any = {}){
        this.id = props.id || 0;
        this.author = props.author || "";
        this.comment = props.comment || "";
        this.rating = props.rating || 0;
        this.fruitId = props.fruitId || 0;
        this.fruit = props.fruit || new Fruit();
    }
}
