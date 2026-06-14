using System;

namespace OperatorApp
{
    public class Money
    {
        public decimal Amount { get; private set; }
        public string Currency { get; private set; }

        public Money(decimal amount, string currency)
        {
            if (amount < 0) throw new ArgumentException("Số tiền không thể âm!");

            Amount = amount;
            Currency = currency.ToUpper();
        }

        private static void KiemTraCungDonVi(Money a, Money b)
        {
            if (a.Currency != b.Currency)
            {
                throw new InvalidOperationException(
                    $"Không thể thực hiện phép toán giữa {a.Currency} và {b.Currency}. " +
                    $"Vui lòng quy đổi về cùng đơn vị trước.");
            }
        }

        // +
        public static Money operator +(Money a, Money b)
        {
            KiemTraCungDonVi(a, b);
            return new Money(a.Amount + b.Amount, a.Currency);
        }

        // -
        public static Money operator -(Money a, Money b)
        {
            KiemTraCungDonVi(a, b);

            if (a.Amount < b.Amount) throw new InvalidOperationException("Kết quả trừ không được âm!");

            return new Money(a.Amount - b.Amount, a.Currency);
        }

        // *
        public static Money operator *(Money m, decimal heSo)
        {
            if (heSo < 0) throw new ArgumentException("Hệ số không thể âm!");

            return new Money(m.Amount * heSo, m.Currency);
        }

        public static Money operator *(decimal heSo, Money m)
        {
            return m * heSo;
        }

        // /
        public static Money operator /(Money m, int soNguoi)
        {
            if (soNguoi <= 0) throw new ArgumentException("Số người phải > 0");

            return new Money(m.Amount / soNguoi, m.Currency);
        }

        // >
        public static bool operator >(Money a, Money b)
        {
            KiemTraCungDonVi(a, b);
            return a.Amount > b.Amount;
        }

        // <
        public static bool operator <(Money a, Money b)
        {
            KiemTraCungDonVi(a, b);
            return a.Amount < b.Amount;
        }

        // ==
        public static bool operator ==(Money a, Money b)
        {
            if (ReferenceEquals(a, b)) return true;

            if (a is null || b is null) return false;

            return a.Amount == b.Amount && a.Currency == b.Currency;
        }

        // !=
        public static bool operator !=(Money a, Money b)
        {
            return !(a == b);
        }

        public override bool Equals(object obj)
        {
            if (obj is Money other) return this == other;

            return false;
        }

        public override int GetHashCode()
        {
            return HashCode.Combine(Amount, Currency);
        }

        // Quy đổi
        public static Money QuyDoi(Money nguon, string donViDich, decimal tyGia)
        {
            if (tyGia <= 0) throw new ArgumentException("Tỷ giá phải > 0");

            return new Money(nguon.Amount * tyGia, donViDich.ToUpper());
        }

        public override string ToString()
        {
            return $"{Amount:N0} {Currency}";
        }
    }
}