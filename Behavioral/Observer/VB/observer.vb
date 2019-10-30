''' <summary>
''' Observer interface, defines Update which should notify the Observer of Subject state change.
''' </summary>
Public Interface IObserver
    Sub Update(ByVal message As String)
End Interface

''' <summary>
''' Implementation of Observer class. Changes to the Subject's state will update the Observer's state.
''' </summary>
Public Class Observer
    Implements IObserver

    Private _objectState As String

    Public Sub Update(ByVal subjectState As String) Implements IObserver.Update
        _objectState = subjectState
    End Sub
End Class

''' <summary>
''' Subject keeps list of Observers and notifies them on state change.
''' </summary>
Public Class Subject
    Private _observers = New List(Of IObserver)
    Private _subjectState As String

    Public Sub SetState(ByVal state As String)
        _subjectState = state
        Notify()
    End Sub

    Public Sub Register(ByVal observer As IObserver)
        _observers.Add(observer)
    End Sub

    Public Sub Remove(ByVal observer As IObserver)
        _observers.Remove(observer)
    End Sub

    Private Sub Notify()
        For Each observer In _observers
            observer.Update($"Subject's state was changed to {_subjectState}")
        Next
    End Sub
End Class

Module Program
    Private Sub Main(ByVal args As String())
        Dim subject = New Subject
        Dim observer = New Observer
        subject.Register(observer)
        subject.SetState("001")
        subject.SetState("002")
    End Sub
End Module

