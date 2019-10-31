import {Comment} from './comment';

export class Fruit {
    id : number;
    name: string;
    description: string;
    photoUrl : string;
    comments? : Comment[] = [];
}
