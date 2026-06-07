/**
 * DESIGN ANALYSIS - ASSIGNMENT 07
 *
 * =========================================================
 * 1. COMPOSITION (HAS-A)
 * =========================================================
 *
 * 1. Library HAS-A Book
 *    - Library quản lý danh sách sách.
 *    - Book không phải là một loại Library.
 *    - Composition phù hợp vì thư viện chứa và quản lý sách.
 *
 * 2. Library HAS-A Reader
 *    - Library quản lý danh sách độc giả.
 *    - Reader không phải là Library.
 *    - Composition giúp thư viện quản lý nhiều loại độc giả khác nhau.
 *
 * 3. Library HAS-A BorrowSlip
 *    - Library lưu trữ và quản lý các phiếu mượn.
 *    - BorrowSlip là dữ liệu thuộc thư viện.
 *
 * 4. Library HAS-A LateFeePolicy
 *    - Library sử dụng chính sách tính phí phạt.
 *    - Dùng Composition để có thể thay đổi chính sách
 *      tại runtime mà không sửa mã nguồn Library.
 *    - Đây là ứng dụng của Strategy Pattern.
 *
 * 5. BorrowSlip HAS-A Reader
 *    - Mỗi phiếu mượn phải biết ai là người mượn sách.
 *
 * 6. BorrowSlip HAS-A Book
 *    - Mỗi phiếu mượn phải biết cuốn sách nào được mượn.
 *
 * 7. Menu HAS-A Library
 *    - Menu sử dụng Library để thao tác dữ liệu.
 *
 * 8. Menu HAS-A Librarian
 *    - Menu sử dụng Librarian để xử lý nghiệp vụ
 *      mượn và trả sách.
 *
 *
 * =========================================================
 * 2. INHERITANCE (IS-A)
 * =========================================================
 *
 * 1. Student IS-A Reader
 *    - Sinh viên là một loại độc giả.
 *    - Có quy định mượn sách và phí phạt riêng.
 *
 * 2. Lecturer IS-A Reader
 *    - Giảng viên là một loại độc giả.
 *    - Có giới hạn mượn và chính sách phí phạt riêng.
 *
 * 3. SeniorReader IS-A Reader
 *    - Người cao tuổi vẫn là một loại độc giả.
 *    - Được miễn phí phạt và có chính sách riêng.
 *
 * 4. StandardFeePolicy IS-A LateFeePolicy
 *    - Chính sách tính phí tiêu chuẩn.
 *
 * 5. CharityFeePolicy IS-A LateFeePolicy
 *    - Chính sách giảm 50% phí phạt.
 *
 * 6. WaivedFeePolicy IS-A LateFeePolicy
 *    - Chính sách miễn toàn bộ phí phạt.
 *
 *
 * =========================================================
 * 3. DESIGN IMPROVEMENT
 * =========================================================
 *
 * Hiện tại lớp Library đang đảm nhận nhiều trách nhiệm:
 * - Quản lý sách
 * - Quản lý độc giả
 * - Quản lý phiếu mượn
 * - Tính thống kê
 * - Tính phí phạt
 *
 * Điều này làm lớp Library khá lớn và khó bảo trì.
 *
 * Đề xuất:
 * - Tách BookService để quản lý sách.
 * - Tách ReaderService để quản lý độc giả.
 * - Tách BorrowService để xử lý mượn/trả sách.
 * - Tách StatisticService để xử lý thống kê.
 *
 * Việc tách này giúp hệ thống tuân thủ nguyên tắc
 * Single Responsibility Principle (SRP),
 * dễ mở rộng và dễ bảo trì hơn trong tương lai.
 */
public class DesignAnalysis {
    // File chỉ dùng để ghi nhận phân tích thiết kế.
}