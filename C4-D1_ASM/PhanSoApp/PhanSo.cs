using System;

namespace PhanSoApp
{
    public class PhanSo
    {
        public int TuSo { get; private set; }
        public int MauSo { get; private set; }

        public PhanSo(int tuSo, int mauSo)
        {
            if (mauSo == 0)
                throw new ArgumentException("Mẫu số phải khác 0!");

            // Đưa dấu âm lên tử số
            if (mauSo < 0)
            {
                tuSo = -tuSo;
                mauSo = -mauSo;
            }

            // Tìm ước chung lớn nhất và rút gọn phân số
            int ucln = UCLN(Math.Abs(tuSo), mauSo);
            TuSo = tuSo / ucln;
            MauSo = mauSo / ucln;
        }

        private static int UCLN(int a, int b)
        {
            while (b != 0)
            {
                int temp = b;
                b = a % b;
                a = temp;
            }

            return a == 0 ? 1 : a;
        }

        public PhanSo RutGon()
        {
            return new PhanSo(TuSo, MauSo);
        }

        public override string ToString()
        {
            if (MauSo == 1) return TuSo.ToString();

            return $"{TuSo}/{MauSo}";
        }

        // ======================
        // Operator số học
        // ======================

        public static PhanSo operator +(PhanSo a, PhanSo b)
        {
            return new PhanSo(
                a.TuSo * b.MauSo + b.TuSo * a.MauSo,
                a.MauSo * b.MauSo
            );
        }

        public static PhanSo operator -(PhanSo a, PhanSo b)
        {
            return new PhanSo(
                a.TuSo * b.MauSo - b.TuSo * a.MauSo,
                a.MauSo * b.MauSo
            );
        }

        public static PhanSo operator *(PhanSo a, PhanSo b)
        {
            return new PhanSo(
                a.TuSo * b.TuSo,
                a.MauSo * b.MauSo
            );
        }

        public static PhanSo operator /(PhanSo a, PhanSo b)
        {
            if (b.TuSo == 0) throw new DivideByZeroException("Không thể chia cho phân số 0!");

            return new PhanSo(
                a.TuSo * b.MauSo,
                a.MauSo * b.TuSo
            );
        }

        // Nâng cao: PhanSo + int
        public static PhanSo operator +(PhanSo a, int b)
        {
            return a + new PhanSo(b, 1);
        }

        public static PhanSo operator +(int a, PhanSo b)
        {
            return new PhanSo(a, 1) + b;
        }

        // ======================
        // Operator so sánh
        // ======================

        public static bool operator ==(PhanSo a, PhanSo b)
        {
            if (ReferenceEquals(a, b)) return true;

            if (a is null || b is null) return false;

            return a.TuSo == b.TuSo && a.MauSo == b.MauSo;
        }

        public static bool operator !=(PhanSo a, PhanSo b)
        {
            return !(a == b);
        }

        public static bool operator <(PhanSo a, PhanSo b)
        {
            return a.TuSo * b.MauSo < b.TuSo * a.MauSo;
        }

        public static bool operator >(PhanSo a, PhanSo b)
        {
            return a.TuSo * b.MauSo > b.TuSo * a.MauSo;
        }

        public override bool Equals(object? obj)
        {
            if (obj is PhanSo other) return this == other;

            return false;
        }

        public override int GetHashCode()
        {
            return HashCode.Combine(TuSo, MauSo);
        }
    }
}