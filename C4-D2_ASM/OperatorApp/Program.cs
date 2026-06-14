using System;

namespace OperatorApp
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("===== BÀI 1 =====");

            Vector2D v1 = new Vector2D(3, 4);
            Vector2D v2 = new Vector2D(1, 2);

            Console.WriteLine($"v1 = {v1}");
            Console.WriteLine($"v2 = {v2}");
            Console.WriteLine($"v1 + v2 = {v1 + v2}");
            Console.WriteLine($"v1 - v2 = {v1 - v2}");
            Console.WriteLine($"v1 * 2 = {v1 * 2}");
            Console.WriteLine($"3 * v2 = {3 * v2}");
            Console.WriteLine($"-v1 = {-v1}");
            Console.WriteLine($"|v1| = {v1.DoDai:F4}");

            Console.WriteLine($"v1 * v2 = {v1 * v2}");
            Console.WriteLine($"v1 == v2 : {v1 == v2}");

            Vector2D v3 = (3.0, 4.0);
            Console.WriteLine($"Tuple -> Vector = {v3}");

            Console.WriteLine();
            Console.WriteLine("===== BÀI 2 =====");

            Money luong = new Money(15000000, "VND");
            Money thuong = new Money(3000000, "VND");

            Money lamThem = luong * 1.5m;

            Console.WriteLine($"Lương cơ bản: {luong}");
            Console.WriteLine($"Thưởng tháng: {thuong}");
            Console.WriteLine($"Lương làm thêm: {lamThem}");
            Console.WriteLine($"Tổng thu nhập: {luong + thuong}");
            Console.WriteLine($"Lương > Thưởng: {luong > thuong}");

            // Thử cộng tiền khác đơn vị
            Money usd = new Money(100, "USD");
            try
            {
                Money tong = luong + usd;
            }
            catch (InvalidOperationException ex)
            {
                Console.WriteLine($"Lỗi: {ex.Message}");
            }

            // Quy đổi USD sang VND
            Money vnd = Money.QuyDoi(usd, "VND", 25500);

            Console.WriteLine($"100 USD = {vnd}");

            // Chia tiền cho số người
            Money hoaDon = new Money(1200000, "VND");
            Console.WriteLine($"Tổng hóa đơn: {hoaDon}");
            Console.WriteLine($"Mỗi người trả: {hoaDon / 4}");
        }
    }
}