use std::time::Duration;
use std::thread;

type Percentage = u8;

#[derive(PartialEq)]
enum Status {
    Queued,
    Downloading,
    Paused,
}
pub struct Download {
    file: String,
    progress: Percentage,
    status: Status
}

// Memento struct for Download
pub struct DownloadPause {
    progress: Percentage
}

impl Download {
    fn new() -> Download {
        Download {
            file: format!("just_testing.xyz"),
            progress: 0,
            status: Status::Queued
        }
    }
    fn start(&mut self) {
        while self.status != Status::Paused || self.progress < 100{
            thread::sleep(Duration::from_secs(1));
            self.progress += 1;
        }
        if self.progress == 100 {
            println!("Finished!");
        }
    }
    fn pause(&mut self) -> DownloadPause {
        self.status = Status::Paused;
        DownloadPause {
            progress: self.progress
        }
    }

    fn unpause(&mut self, dp: DownloadPause) {
        self.progress = dp.progress();
        self.start();
    }
}

impl DownloadPause {
    fn progress(&self) -> Percentage {
        self.progress
    }
}

fn main() {
    let mut mp3 = Download::new();
    mp3.start();
    let mp3_paused = mp3.pause();
    mp3.unpause(mp3_paused);
}
