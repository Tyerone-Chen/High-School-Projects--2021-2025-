USE Education
Go

Create Procedure sp_UpdateInstructorPhoneNum
	@ID Int,
	@NewNumber Varchar(12)

As
Begin
	Declare @Error Int;

	Update Instructor
	Set InstructorPhone = @NewNumber
	Where InstructorID = @ID 
	Set @Error = @@ERROR

	If @Error = 0
		Print 'New Row Added Succesfully';
	Else
		Begin
			Print 'Unknown Error Has Occured';
		End
	End
Go
