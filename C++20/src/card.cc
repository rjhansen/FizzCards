/* Copyright (c) 2017-2023, Robert J. Hansen.
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

#include "card.h"
#include <array>
#include <iostream>
#include <stdexcept>

using engineering::hansen::Card;
using std::array;
using std::invalid_argument;
using std::ostream;
using std::string;

namespace {
const array<string, 4> SUITS { "Clubs", "Hearts", "Diamonds", "Spades" };
const array<string, 13> FACES { "Ace", "Two", "Three", "Four", "Five",
    "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
}

Card::Card()
    : value { 0 }
{
}

Card::Card(uint8_t val)
    : value { val }
{
    if (val > 51)
        throw invalid_argument("invalid card value");
}

Card::Card(const Card& other)
    : value { other.value }
{
}

Card::Card(const Card&& other)
    : value { other.value }
{
}

Card& Card::operator=(const Card&& other)
{
    value = other.value;
    return *this;
}

string Card::toString() const noexcept
{
    return FACES.at(value % 13) + " of " + SUITS.at(value / 13);
}

uint8_t Card::getValue() const noexcept
{
    return value;
}

bool engineering::hansen::operator<(const Card& lhs, const Card& rhs) noexcept
{
    return lhs.getValue() < rhs.getValue();
}

bool engineering::hansen::operator==(const Card& lhs, const Card& rhs) noexcept
{
    return lhs.getValue() == rhs.getValue();
}

bool engineering::hansen::operator>(const Card& lhs, const Card& rhs) noexcept
{
    return lhs.getValue() > rhs.getValue();
}

ostream& engineering::hansen::operator<<(ostream& os, const Card& card)
{
    os << card.toString();
    return os;
}
