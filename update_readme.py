from datetime import datetime

def update_readme():
    readme_path = "README.md"

    with open(readme_path, "a") as readme_file:
        readme_file.write(f"\n\nUpdated on {datetime.now().isoformat()} UTC")

if __name__ == "__main__":
    update_readme()