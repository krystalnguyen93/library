package bookStore;

public class MainApp {
	public static void main(String[] args) {
		Book book1 = new Book();
		book1.name = "A Culture Turned: Using UGRs to boost performance and culture";
		book1.author = "Steve Simpson";
		book1.ISBN = "1481017659";

		Book book2 = new Book();
		book2.name = "How to Win Friends & Influence People";
		book2.author = "Dale Carnegie";
		book2.ISBN = "9357400729";

		Book book3 = new Book();
		book3.name = "The Creative Act: A Way of Being";
		book3.author = "Rick Rubin";
		book3.ISBN = "0593652886";

		Book[] books = { book1, book2, book3 };

		Type type1 = new Type();
		type1.type = "Creativity";

		Type type2 = new Type();
		type2.type = "Novel";

		BookAndType bookAndType1 = new BookAndType();
		bookAndType1.book = book1;
		bookAndType1.type = type1;

		BookAndType bookAndType2 = new BookAndType();
		bookAndType2.book = book2;
		bookAndType2.type = type1;

		BookAndType bookAndType3 = new BookAndType();
		bookAndType3.book = book3;
		bookAndType3.type = type1;

		Location location1 = new Location();
		location1.name = "Ha Noi";
		location1.address = "Nha Nam";

		Location location2 = new Location();
		location2.name = "HCM";
		location2.address = "Nha Xuat Ban Tre";

		BookInLocation book1InLocation1 = new BookInLocation();
		book1InLocation1.book = book1;
		book1InLocation1.location = location1;
		book1InLocation1.quanity = 100;

		BookInLocation book2InLocation1 = new BookInLocation();
		book2InLocation1.book = book2;
		book2InLocation1.location = location1;
		book2InLocation1.quanity = 200;

		Customer customer1 = new Customer();
		customer1.setName("Linh");
		customer1.setId(12345678);
		customer1.setDob("01/12/1993");
		customer1.setPhoneNumber("0987654321");

		Customer customer2 = new Customer();
		customer2.setName("Hoa");
		customer2.setId(92345679);
		customer2.setDob("01/01/1993");
		customer2.setPhoneNumber("0987654654");

		Customer customer3 = new Customer();
		customer3.setName("Nga");
		customer3.setId(92345345);
		customer3.setDob("01/01/1993");
		customer3.setPhoneNumber("0987654765");

		Customer[] customers = { customer1, customer2, customer3 };

		BorrowReturn cusBorrowReturn1 = new BorrowReturn();
		cusBorrowReturn1.book = book1;
		cusBorrowReturn1.borrowDate = "20/01/2023";
		cusBorrowReturn1.customer = customer1;
		cusBorrowReturn1.returnDate = null;

		BorrowReturn cusBorrowReturn2 = new BorrowReturn();
		cusBorrowReturn2.book = book2;
		cusBorrowReturn2.borrowDate = "19/01/2023";
		cusBorrowReturn2.customer = customer1;
		cusBorrowReturn2.returnDate = "25/01/2023";

		BorrowReturn cusBorrowReturn3 = new BorrowReturn();
		cusBorrowReturn3.book = book2;
		cusBorrowReturn3.borrowDate = "18/01/2023";
		cusBorrowReturn3.customer = customer2;
		cusBorrowReturn3.returnDate = "27/01/2023";

		BorrowReturn cusBorrowReturn4 = new BorrowReturn();
		cusBorrowReturn4.book = book3;
		cusBorrowReturn4.borrowDate = "22/01/2023";
		cusBorrowReturn4.customer = customer3;
		cusBorrowReturn4.returnDate = "30/01/2023";

		BorrowReturn[] borrowReturns = { cusBorrowReturn1, cusBorrowReturn2, cusBorrowReturn3, cusBorrowReturn4 };

		for (Customer customer : customers) {
			System.out.println("Borrowing Book list of " + customer.getName());
			BorrowReturn[] borrowReturnsInDetail = getBorrowReturn(borrowReturns, customer);
			for (BorrowReturn borrowReturnInDetail : borrowReturnsInDetail) {
				System.out.println(borrowReturnInDetail.book.name + " ------ " + "Borrowing Date: "
						+ borrowReturnInDetail.borrowDate);
			}
			System.out.println();
		}

		for (Book book : books) {
			System.out.println("Status of the book: " + book.name);
			BorrowReturn[] borrowReturnBooksInDetail = getBorrowReturnBook(borrowReturns, book);
			for (BorrowReturn borrowReturnBookInDetail : borrowReturnBooksInDetail) {
				if (borrowReturnBookInDetail.returnDate == null) {
					System.out.println(
							"Customer: " + borrowReturnBookInDetail.customer.getName() + " ------ " + "Borrowing Date: "
									+ borrowReturnBookInDetail.borrowDate + " ------ " + "Hasn't returned the book");
				} else {
					System.out.println("Customer: " + borrowReturnBookInDetail.customer.getName() + " ------ "
							+ "Borrowing Date: " + borrowReturnBookInDetail.borrowDate + " ------ "
							+ "Returnning Date: " + borrowReturnBookInDetail.returnDate);
				}
			}
			System.out.println();
		}
	}

	public static BorrowReturn[] getBorrowReturn(BorrowReturn[] borrowReturnList, Customer customer) {
		int arraySize = 0;
		for (BorrowReturn borrowReturn : borrowReturnList) {
			if (borrowReturn.customer.equals(customer)) {
				arraySize++;
			}
		}
		BorrowReturn[] borrowReturns = new BorrowReturn[arraySize];
		if (arraySize == 0) {
			return borrowReturns;
		}
		int index = 0;
		for (BorrowReturn borrowReturn : borrowReturnList) {
			if (borrowReturn.customer.equals(customer)) {
				borrowReturns[index] = borrowReturn;
				index++;
			}
		}
		return borrowReturns;

	}

	public static BorrowReturn[] getBorrowReturnBook(BorrowReturn[] borrowReturnBookList, Book book) {
		int arraySize = 0;
		for (BorrowReturn borrowReturn : borrowReturnBookList) {
			if (borrowReturn.book.equals(book)) {
				arraySize++;
			}
		}
		BorrowReturn[] borrowReturns = new BorrowReturn[arraySize];
		if (arraySize == 0) {
			return borrowReturns;
		}
		int index = 0;
		for (BorrowReturn borrowReturn : borrowReturnBookList) {
			if (borrowReturn.book.equals(book)) {
				borrowReturns[index] = borrowReturn;
				index++;
			}
		}
		return borrowReturns;

	}
}
