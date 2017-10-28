

class HindiLanguage(object):

    """A simple localizer a la gettext"""

    def __init__(self):
        self.trans = dict(dog="कुत्ता", cat="बिल्ली")

    def get(self, msgid):
        """We'll punt if we don't have a translation"""
        return self.trans.get(msgid, str(msgid))


class EnglishLanguage(object):

    """Simply echoes the msg ids"""

    def get(self, msgid):
        return str(msgid)


def get_localizer(language="English"):
    """The factory method"""
    languages = dict(English=EnglishLanguage, Hindi=HindiLanguage)
    return languages[language]()


if __name__ == '__main__':
    # Create our localizers
    e, h = get_localizer(language="English"), get_localizer(language="Hindi")
    # Localize some text
    for msgid in "dog cat".split():
        print(e.get(msgid), h.get(msgid))

