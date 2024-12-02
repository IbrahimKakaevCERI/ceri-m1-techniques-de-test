import xml.etree.ElementTree as ET
import json

def generate_badge(checkstyle_report, output_file):
    tree = ET.parse(checkstyle_report)
    root = tree.getroot()

    errors = len(root.findall(".//error"))
    message = f"{errors} issue(s)" if errors else "Passing"

    badge_data = {
        "schemaVersion": 1,
        "label": "Checkstyle",
        "message": message,
        "color": "brightgreen" if errors == 0 else "red"
    }

    with open(output_file, "w") as f:
        json.dump(badge_data, f)

# Usage example
generate_badge("target/checkstyle-result.xml", "badge.json")
