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

#ifndef CARD_H
#define CARD_H

#include <cstdint>
#include <iosfwd>
#include <string>

namespace engineering {
namespace hansen {
    class Card {
    public:
        Card();
        Card(uint8_t val = 0);
        Card(const Card& other);
        Card(const Card&& other);
        Card& operator=(const Card&& other);
        std::string toString() const noexcept;
        uint8_t getValue() const noexcept;

    private:
        uint8_t value;
    };

    bool operator<(const Card& lhs, const Card& rhs) noexcept;
    bool operator==(const Card& lhs, const Card& rhs) noexcept;
    bool operator>(const Card& lhs, const Card& rhs) noexcept;
    std::ostream& operator<<(std::ostream& os, const Card& c);
}
}

#endif