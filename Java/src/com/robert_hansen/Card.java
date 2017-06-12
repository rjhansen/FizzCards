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

/** A simple data structure representing a playing card.  It supports
 * the normal operations for cards: they can be compared and checked for
 * equality.
 * 
 * @author Robert J. Hansen
 */
public class Card implements Comparable<Card> {
    private final int value;
    
    /** Initializes a new card from a given index.
     *
     * The index divided by thirteen gives the suit (in the range of
     * ["Clubs", "Hearts", "Diamonds", "Spades"].  The index modulo
     * thirteen gives the face value following normal ordering: Ace,
     * Two, Three ... Queen, King.
     * 
     * @param index The value of the card.
     * @throws IllegalArgumentException if index is outside (0, 51) inclusive.
     */
    public Card(int index) {
        if (index < 0 || index > 51)
            throw new IllegalArgumentException();
        value = index;
    }
    
    @Override
    public String toString() {
        final String[] SUITS = new String[] 
        { "Clubs", "Hearts", "Diamonds", "Spades"};
        final String[] FACES = new String[] 
        { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", 
        "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

        StringBuilder sb = new StringBuilder();
        sb.append(FACES[value % 13]);
        sb.append(" of ");
        sb.append(SUITS[value / 13]);
        return sb.toString();
    }
    
    /** Returns the ordinal value of this card.
     *
     * @return The ordinal value of this card.
     */
    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Card o) {
        return value < o.value ? -1 : value == o.value ? 0 : 1;
    }
    
    @Override
    public boolean equals(Object o) {
        return o.getClass() == Card.class && ((Card)o).value == value;
    }

    @Override
    public int hashCode() {
        return 371 + this.value;
    }    
}
