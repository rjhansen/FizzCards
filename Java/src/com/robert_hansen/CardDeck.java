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
import java.security.SecureRandom;
import java.util.List;
import java.util.ArrayList;

/** Represents a deck of cards.  Since a deck of cards is conceptually
 * identical to a deque of &lt;Cards&gt;, we get most of our functionality
 * for free via inheritance.
 *
 * @author Robert J. Hansen
 */
public class CardDeck extends java.util.ArrayDeque<Card> {
    /** Creates a new deck of 52 cards, in normal order.
     */
    public CardDeck() {
        for (int i = 0 ; i < 52 ; i += 1)
            this.push(new Card(i));
    }
    
    /** Creates a new deck of cards from source.
     *
     * @param source The Collection&lt;Card&gt; to read from.
     */
    public CardDeck(java.util.Collection<Card> source) {
        source.stream().forEach(this::push);
    }
    
    /** Do a Fisher-Yates shuffle on the deck.  Computationally
     * inefficient, but it has some very nice mathematical
     * properties and is recommended by Knuth.
     */
    public void shuffle() {
        final SecureRandom rng = new SecureRandom();
        List<Card> beginState = new ArrayList<>(this);
        this.clear();
        while (! beginState.isEmpty()) {
            final int index = rng.nextInt(beginState.size());
            this.push(beginState.get(index));
            beginState.remove(index);
        }
    }
    
    /** Deals one card off the top of the deck.  Implemented via the pop()
     * method, this differs in that it will return a null on an empty deck.
     *
     * @return The topmost card, or null if the deck is empty.
     */
    public Card dealOneCard() {
        try {
            return this.pop();
        } catch (java.util.NoSuchElementException nsee) {
            return null;
        }
    }
    
    /** A simple do-mostly-nothing main().  Unit tests are elsewhere.
     *
     * @param args Command-line arguments (ignored).
     */
    public static void main(String[] args) {
        CardDeck cd = new CardDeck();
        cd.shuffle();
        cd.stream().forEach((c) -> {System.out.println(c);});
    }
}
