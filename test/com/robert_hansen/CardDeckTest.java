/* Copyright (c) 2016, Robert J. Hansen.
*
* Permission to use, copy, modify, and/or distribute this software for
* any purpose with or without fee is hereby granted, provided that the
* above copyright notice and this permission notice appear in all copies.
*
* THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
* WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
* MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
* ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
* WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
* ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
* OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
*/

package com.robert_hansen;

import org.junit.Test;
import static org.junit.Assert.*;

public class CardDeckTest {

    @Test
    public void testShuffle() {
        System.out.println("testing shuffling the deck");
        CardDeck instance = new CardDeck();
        instance.shuffle();
        Card first = instance.pop();
        Card second = instance.pop();
        Card third = instance.pop();
        Card fourth = instance.pop();
        
        // The odds of this triggering by chance: about one in three million
        if (first.getValue() == 0 &&
                second.getValue() == 1 && 
                third.getValue() == 2 &&
                fourth.getValue() == 4)
            fail("shuffle left deck ordered");
        else if (first.getValue() == 51 &&
                second.getValue() == 50 &&
                third.getValue() == 49 &&
                fourth.getValue() == 48)
            fail("shuffle left deck ordered");
    }

    @Test
    public void testDealOneCard() {
        System.out.println("testing dealing one card off new deck");
        CardDeck instance = new CardDeck();
        Card expResult = new Card(51);
        Card result = instance.dealOneCard();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDeal53Cards() {
        System.out.println("testing dealing 53 cards off new deck");
        CardDeck instance = new CardDeck();
        for (int i = 0 ; i < 52 ; i += 1)
            assertNotNull(instance.dealOneCard());
        Card c = instance.dealOneCard();
        assertNull(c);
    }
}
