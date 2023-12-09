/* Copyright (c) 2017, Robert J. Hansen.
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
#include <stdexcept>
#include <array>
#include <iostream>

namespace
{
    const std::array<std::string, 4> SUITS { "Clubs", "Hearts", "Diamonds", "Spades" };
    const std::array<std::string, 13> FACES { "Ace", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
}

engineering::hansen::Card::Card(uint8_t val) : value { val }
{
    if (val < 0 || val > 51) throw std::invalid_argument("invalid card value");
}

std::string engineering::hansen::Card::toString() const noexcept
{
    return FACES.at(value % 13) + " of " + SUITS.at(value / 13);
}

uint8_t engineering::hansen::Card::getValue() const noexcept
{
    return value;
}

bool engineering::hansen::operator<(const engineering::hansen::Card& lhs, const engineering::hansen::Card& rhs)
{
    return lhs.getValue() < rhs.getValue();
}

bool engineering::hansen::operator==(const engineering::hansen::Card& lhs, const engineering::hansen::Card& rhs)
{
    return lhs.getValue() == rhs.getValue();
}

bool engineering::hansen::operator>(const engineering::hansen::Card& lhs, const engineering::hansen::Card& rhs)
{
    return lhs.getValue() > rhs.getValue();
}

std::ostream& engineering::hansen::operator<<(std::ostream& os, const engineering::hansen::Card& card)
{
    os << card.toString();
    return os;
}
