package main

import (
	"errors"
	"fmt"
	"math/rand"
	"time"
)

// Card represents a normal poker card
type Card struct {
	value int
}

// Deck represents a normal poker deck
type Deck struct {
	cards []Card
}

var suits []string
var values []string
var r *rand.Rand

func init() {
	r = rand.New(rand.NewSource(time.Now().Unix()))
	suits = []string{"Clubs", "Hearts", "Diamonds", "Spades"}
	values = []string{"Two", "Three", "Four", "Five", "Six", "Seven",
		"Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"}
}

// NewDeck Create a new Deck with the normal fifty-two cards
func NewDeck() *Deck {
	rv := Deck{}
	for i := 0; i < 52; i++ {
		rv.cards = append(rv.cards, Card{value: i})
	}
	return &rv
}

func (c Card) String() string {
	return values[c.value%13] + " of " + suits[c.value/13]
}

// Shuffle Shuffles a given Deck, returning the Deck
func (d *Deck) Shuffle() *Deck {
	rand.Shuffle(len(d.cards), func(i, j int) {
		d.cards[i], d.cards[j] = d.cards[j], d.cards[i]
	})
	return d
}

// DealCard Deals a card off the top of the Deck
func (d *Deck) DealCard() (*Card, error) {
	if len(d.cards) == 0 {
		return nil, errors.New("empty deck")
	}
	rv := d.cards[0]
	d.cards = append(d.cards[:0], d.cards[1:]...)
	return &rv, nil
}

func main() {
	deck := NewDeck().Shuffle()
	card, error := deck.DealCard()
	for error == nil {
		fmt.Println(card)
		card, error = deck.DealCard()
	}
}
