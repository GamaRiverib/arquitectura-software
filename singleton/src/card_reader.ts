import { v4 } from "uuid";

let instanceCounter: number = 0;

export class CardReader {

  private static instance: CardReader | null = null;

  private constructor() {
    console.log(`New CardReader instance: ${++instanceCounter}`);
  }

  static getInstance(): CardReader {
    if (CardReader.instance === null) {
      CardReader.instance = new CardReader();
    }
    return CardReader.instance;
  }

  read(): string {
    return v4();
  }

}