Public Interface ITarget
    Function GetRequest() As String
End Interface

Friend Class Adaptee
    Public Function GetSpecificRequest() As String
        Return "Specific request."
    End Function
End Class

Friend Class Adapter
    Implements ITarget

    Private ReadOnly _adaptee As Adaptee

    Public Sub New(ByVal adaptee As Adaptee)
        _adaptee = adaptee
    End Sub

    Public Function GetRequest() As String Implements ITarget.GetRequest
        Return $"{_adaptee.GetSpecificRequest}"
    End Function
End Class

Friend Class Program
    Private Shared Sub Main(ByVal args As String())
        Dim adaptee = New Adaptee
        Dim target As ITarget = New Adapter(adaptee)
        Console.WriteLine("Adaptee interface is incompatible with the client.")
        Console.WriteLine("But with adapter client can call it's method.")
        Console.WriteLine(target.GetRequest)
    End Sub
End Class
