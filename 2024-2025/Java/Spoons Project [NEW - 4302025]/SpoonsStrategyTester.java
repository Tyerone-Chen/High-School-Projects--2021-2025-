public class SpoonsStrategyTester {

    public static void main(String[] args) {
        // Swap in any bot to test
        SpoonsStrategy bot = new TyeroneBiasedBotPlayer("Even TestBot");

        System.out.println("=== Testing Strategy: " + bot.getStrategyName() + " ===");

        String[] testSequence = {
            "2-H", "2-D", "2-S", "3-S", // should trigger win condition
            "5-H", "A-D", "J-S", "2-C"         // noise cards
        };

        // Feed cards one at a time and simulate one full "turn" per card
        for (String code : testSequence) {
            Card incoming = Card.fromCode(code);
            System.out.println("\n>>> Incoming: " + incoming);

            bot.receiveCard(incoming);

            Card toPass = bot.decideCardToPass();
            if (toPass != null) {
                System.out.println("Passed: " + toPass);
            } else {
                System.out.println("No card passed yet.");
            }

            System.out.println("Hand: " + bot.toString());
            System.out.println("Win condition: " + bot.hasFourOfAKind());
        }

        System.out.println("\n=== Test Complete ===");
    }
}
