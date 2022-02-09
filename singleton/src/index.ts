import { CardReader } from "./card_reader";

function readUserCard(user: string): void {
  const reader = CardReader.getInstance();
  const card_number = reader.read();
  console.log(`${user}: ${card_number}`);
}

for (let i = 1; i <= 10; i++) {
  readUserCard(`User #${i}`);
}